1. we use 2-pointers approach for variable size in sliding window.
2. we use left and right pointer 
    where left pointer is used to remove the element from start of the window 
        if window is invalid 
            left++;
    right pointer is used for the end of current window 
        tries to include new element
        increments
        expand the window size
    left pointer -> 
        tries to remove element
        increments
        shrink window size

3. when u need to return the maxlen of subarray when sum<= target
    shrink the window ,when condition becomes invalid,when sum>target (left++) 
    
4. when u need to return the minlen of subarray when sum>=target
    shrink the window when condition becomes valid ,when sum>=target
