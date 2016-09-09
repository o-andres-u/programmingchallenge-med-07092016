module.exports = class Alg {

  constructor(input = []) {
    this.input = input;
    this.sorted = input.sort();
    this.size = this.input.length;
  }

  find() {
    const group = [];
    const half = this.total(this.input) / 2;
    const positions = [];
    for (let i = 0; i < this.input.length; i++) {
      group.push(this.sorted[i]);
      positions.push(i);
      if (this.total(group) === half) { break };
      const second = this.input.length - i - 1;
      group.push(this.sorted[second]);
      positions.push(second);
      if (this.total(group) === half) { break };
    }

    const remanent = this.input.filter((e, idx) => positions.indexOf(idx) === -1);

    return [group, remanent];
  }

  total(list) {
    return list.reduce((pre, cur, idx, total) => pre + cur, 0);
  }

}