/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findMissingElements = function(nums) {
        const set= new Set();
        let max= -Infinity;
        let min= Infinity;
        for(let num of nums)
        {
            set.add(num);
            min= Math.min(min,num);
            max= Math.max(max,num);

        }
        const ans= [];
        for(let i=min;i<=max;i++)
        {
            if(!set.has(i)) ans.push(i);
        }
        return ans;
};

        
