////////////////////////////
// array literals
const nums = [10, 20, 30, 40, 50, 60, 70, 80];

/////////////////////////////
// loops 
// - basic for loop
// - for ... of
// - for ... in 
// for (let i = 0; i < nums.length; i++) {
//     console.log(nums[i]);

// }

for (let index in nums) { // use "in" for enumerables like objects
    console.log(index)
}

for (let num of nums) { // use "of" when looping over an iterable (collection or array etc.)
    console.log(num)
}


///////////////////////////////
// functional programming
// - Array methods available: forEach, filter, reduce, map
// nums.forEach(el => console.log(el));

// (like Java stream methods)
//        ArrayList<Integer> nums = new ArrayList<>(); nums.add(1); nums.add(2); nums.add(3);
//        nums.stream().____(num -> System.out.print(num));