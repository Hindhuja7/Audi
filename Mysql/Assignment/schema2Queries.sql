// 1. Display all the details of all projects in Bangalore.
Note: display the ascending order of jobNO

SELECT * FROM project where jobcity='bangalore' order by jobNo;

output:
jobNo   jobName jobCity                           
j1      ERP     Bangalore                         
j5      CMS     Bangalore 

// 2. Display supNo in descending order suppliers who supply for project j1 
SELECT supNo FROM supprodproj where jobNo='j1'order by supNo desc;

output=
supNo                                             
s4                                                
s3                                                
s1                                                
s1

// 3. Display the supplier  who supplies the part p1 for the project j1.

SELECT supNo FROM supprodproj where prodNo= 'p1' and jobNo='j1';
output:
supNo                                             
s1 

// 4. Display the project names for the projects supplied by the supplier s1.
Note: display the project names in ascending order 

select project.jobName from project where jobNo in (SELECT jobNo FROM supprodproj where supNo = 's1')
order by project.jobName;
jobName                                           
ERP                                               
Sales  


// 5. Display the supplier who supply projects J1 and J2
Note: display the supNo, jobno
SELECT supNo, jobno FROM supprodproj where jobNo in ('j1', 'j2') order by jobno;

output:
supNo   jobno                                     
s1      j1                                        
s1      j1                                        
s3      j1                                        
s4      j1                                        
s3      j2                                        
s4      j2   


// 6. Display the parts supplied to any project in Bangalore
Note: display the prodNo in descending order

select prodNo from products where prodCity = 'Bangalore' order by prodNo desc;

prodNo                                            
p5                                                
p4                                                
p1 

// 7. Display the parts(prodname) supplied to any project by a supplier in the same city.
Note: display the prodname , supplier city, product city
      display the details in the order of prodname descending.

select  p.prodname, s.supCity,p.prodCity
from products p, supplier s, project pr, supprodproj sp
where sp.supNo=s.supNo
and sp.prodNo=p.prodNo
and sp.jobNo=pr.jobNo
and p.prodCity=s.supCity
order by p.prodname desc;

output:
prodname        supCity prodCity                  
Sql Server      Hyderabad       Hyderabad         
MySql   Bangalore       Bangalore 


// 8. Display the total number of projects supplied by supplier s3;
select count(jobNo) from supprodproj where supNo = 's3';

output:
count(jobNo)                                      
2 

// 9. Display the total quantity of part p1 supplied by supplier s1.
Note: display prodno and total quantity as Total_Quantity

select prodNo,sum(quantity) Total_Quantity
from supprodproj 
where supNo='s1' 
and prodNo='p1' 
group by prodNo;

output:
prodNo  Total_Quantity                            
p1      3   


//10. Display the parts supplied to any project in Bangalore by the 
Supplier in Bangalore
Note: display the prodName, jobCity, supCity 
      display details in the order of prodName in descending order

select p.prodName,pr.jobCity,s.supCity
from supplier s, project pr, products p,supprodproj sp
where sp.supNo=s.supNo
and sp.prodNo=p.prodNo
and sp.jobNo=pr.jobNo
and pr.jobCity='Bangalore'
and s.supCity='Bangalore'
order by p.prodName desc;

output:
prodName        jobCity supCity                   
Windows OS      Bangalore       Bangalore         
Sql Server      Bangalore       Bangalore

// 11. Display the project names ,supCity, jobCity for project using atleast one supplier not in the same city.
Note: display the details in the order of projectnames(ie. jobName)

select pr.jobName,s.supCity,pr.jobCity
from supplier s, project pr,supprodproj sp
where sp.supNo=s.supNo
and sp.jobNo=pr.jobNo
and s.supCity!=pr.jobCity
order by pr.jobName;

output:
jobName         supCity      	jobCity                           
Accounting      Hyderabad       Chennai           
ERP     	Chennai 	Bangalore                         
ERP     	Hyderabad       Bangalore                 
ERP     	Hyderabad       Bangalore                 
ERP     	Hyderabad       Bangalore                 
Sales   	Bangalore       Hyderabad                 
UI      	Bangalore       Hyderabad 


// 12. Display project (prodNo) for projects using atleast one part available 
from supplier S1.
Note: display details in descending order of prodNo.


select prodNo
from supprodproj spp
where supNo='s1'
group by prodNo
having count(quantity)>=1
order by prodNo desc;

output: 
prodNo                                            
p2                                                
p1 


// 13. For each part being supplied to a project, get the part number and 
the corresponding total quantity(Total_Quantity).
Note: display the jobNo, prodNo, Total_Quantity

select jobNo,prodNo,sum(quantity) Total_Quantity
from supprodproj 
group by jobNo,prodNo
order by jobNo;

output:
jobNo   prodNo  Total_Quantity                    
j1      p1      1                                 
j1      p2      4                                 
j1      p4      3                                 
j2      p2      2                                 
j2      p4      1                                 
j3      p1      1                                 
j4      p1      2                                 
j4      p2      2                                 
j5      p2      3                                 
j5      p3      3 
