#!/usr/bin/env ruby

def split(list)
    if sum(list) % 2 != 0
        return nil
    end

    left, right = [], []
    sum_left, sum_right = 0, 0

    list.each_with_index do |n, i|
        break if sum_left > sum_right
        left = list[0, i]
        right = list[i, list.size]
        sum_left = sum(left)
        sum_right = sum(right)
        if sum_left == sum_right
            return { a: left, b: right }            
        end
    end

    delta = (sum_left - sum_right).abs / 2

    left.each_with_index do |n, i|
        if n == delta
            left.delete_at i
            return { a: left, b: right + [n] }
        end
    end

    candidates = {}
    left.each_with_index do |n, i|
        next if n >= delta
        candidates[i] = n
        if sum(candidates.values) == delta
            right += candidates.values
            candidates.each do |k, i|
                left.delete_at k
            end
            return { a: left, b: right }   
        end
    end
    nil
end

def sum(list)
    if !list.nil?
        list.inject(0, :+)
    else 
        0
    end
end

input = [1,3,4,2]
puts "Input: #{input}"
split_input = split(input)
throw Exception.new("Assertion failed.") unless split_input == { a: [1, 4], b: [2, 3]}
puts "Result #{split_input}"
puts

input = [1,1,1,4,3,6]
puts "Input: #{input}"
split_input = split(input)
throw Exception.new("Assertion failed.") unless split_input == { a: [1, 4, 3], b: [6, 1, 1]}
puts "Result #{split_input}"
puts

input = []
puts "Input: #{input}"
split_input = split(input)
throw Exception.new("Assertion failed.") unless split_input == nil
puts "Result #{split_input}"
puts

input = [1, 2, 3, 3]
puts "Input: #{input}"
split_input = split(input)
throw Exception.new("Assertion failed.") unless split_input == nil
puts "Result #{split_input}"
puts
# Add more test cases here :)

puts "It works!"