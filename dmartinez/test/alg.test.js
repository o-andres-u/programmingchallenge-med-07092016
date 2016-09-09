const Alg = require('../lib/alg');
const assert = require('assert');

describe('Algorithm', () => {

  it('1: find groups', () => {
    const input = [1, 3, 4, 2];
    const alg = new Alg(input);
    const expected = [
      [1, 4],
      [2, 3]
    ];
    assert.strictEqual(alg.total(alg.sorted), 10);
    assert.deepEqual(alg.sorted, [1, 2, 3, 4]);
    const groups = alg.find();
    assert.deepEqual(groups, expected);
  });

});