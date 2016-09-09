#!/usr/bin/env ruby

def split(list)
    if sum(list) % 2 != 0
        return nil
    end

    list.sort!

    left, right = [], []
    sum_left, sum_right = 0, 0

    list.each_index do |i|
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
