To retrive word containing only of certain length we will use 
Example: select * from emp where ename like '_____';

To retrive chars containing anywhere in word
Example: select * from emp where ename like '%ab%';

it doesnt matter u use '%%' or '%' works same
Example: select * from emp where ename like "%%";
select * from emp where ename like "%";

count,avg,max,min,sum only consider integer and decimal
while doing avg internally it calculates sum%count it takes only the values of integer and decimal but not NULL values


mysql>  select ename from emp where ename rlike '[KE]'; retrives containg K or E