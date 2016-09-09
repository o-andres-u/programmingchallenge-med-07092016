var mainProcess = function(mainArray) {
    var total1 = 0, total2 = 0, arr1 = [], arr2 = [];
    var arrSorted = _.sortBy(mainArray, (num) => {return num}).reverse();
    for (elem of arrSorted) {
        if (total1 < total2) {
            arr1.push(elem);
            total1 += elem;
        }
        else {
            arr2.push(elem);
            total2 += elem;
        }
    }
    if (validate(arr1, arr2)) {
        return [arr1, arr2];
    }
    else{
        console.log('no es posible construir los vectores');
        return [[],[]];
    }
};
var validate = function (arr1, arr2){
    var iterate = function(memo, num){
        return memo + num;
    };
    return _.reduce(arr1, iterate, 0) === _.reduce(arr2, iterate, 0);
};
//-------------   INGRESE AQUI SU ARRAY    -----------------
var mainArray = [4,5,6,9,8,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,4,5,6,2,1,4,5,7,9,8,];

var init = new Date().getTime();
var result = mainProcess(mainArray);
var finish = new Date().getTime();

console.log('Array Original', mainArray);
console.log('Array 1', result[0]);
console.log('Array 2', result[1]);
console.log('time:', finish + 'ms - ' + init + 'ms = ', finish - init + 'ms');
//----------------------------------------------------------
// para ver el resultado abra el index.html con un browser y abra la consola