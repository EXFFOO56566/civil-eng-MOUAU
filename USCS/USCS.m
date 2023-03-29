

disp('This code is for soil classification based on Unified Soil Classification System (USCS). It is developed by Gökmen Dedemen (email adress: gokmendedemen1993@gmail.com) at Civil Engineering Department of METU, in Ankara, Turkey in February 2015.')


finecontent= input('Enter the percentage of soil passing US sieve No.200 (0.074 mm):');

percentage=100-finecontent;



if percentage>50



Sieve_result =input('Please enter the data obtained at the end of sieve analysis in the matrix form. The first column represents the sieve mesh (in mm)\n and the second column represents the mass retained on the Sieve (in g).\n Please do not forget to take the soil remained on the pan.Enter sieve mesh value for the pan as 0.0 e.g. Sieve_result = [4.76 0.0;3.36 180.0;2.38 125.0;2.0 75.0;1.19 60.0;0.84 35.0;0.42 25.0;0.0 50.0]\n');

 
  sieve_size= Sieve_result(:,1);
  mass_retained=Sieve_result(:,2);
  no= length(sieve_size);


        for i = 1 : no
            if sieve_size(i,1) <75 && sieve_size(i,1) >= 4.75
                gravel(i,1) = mass_retained(i);
            end
        end
        
        Gravel=sum(gravel(:,1));
       

        for i = 1 : no
            if sieve_size(i,1) <4.75 && sieve_size(i,1) >= 0.075
                sand(i,1) = mass_retained(i);
            end
        end
        
        Sand=sum(sand(:,1));
        
        
  
  
  for i=2:no
      
      mass_retained(i)= mass_retained(i)+mass_retained(i-1);
  end
  
  tot_mass=mass_retained(no);
  
  percent_gravel=(Gravel/tot_mass)*100

 percent_sand= (Sand/tot_mass)*100
  
  
  for i=1:no
      
  percent_cum_ret(i)= (mass_retained(i)/mass_retained(no))*100;
  
  end
  
  
  for i=1:no 
      
percent_cum_passing(i)=100-percent_cum_ret(i);
  end
  
  result=percent_cum_passing';
  
  [result, index] = unique(result);
         
        D10 = interp1(result, sieve_size(index), 10, 'pchip')
       
        D30 = interp1(result, sieve_size(index), 30, 'pchip')
       
        D60 = interp1(result, sieve_size(index), 60, 'pchip')
        
        
        result;

        sieve_size=sieve_size(index);
        
        
      
        Cu=D60/D10

        Cc=(D30^2)/(D10*D60)
        
      
            
        
        
        
        
        
        
        
        
        
        figure;
           
          CCurve_h = semilogx(sieve_size,result,'Linewidth' , 2.0, 'Color' , [1 0 1] );
            title('Grain Size Distribution ' , 'Color' , [1 0.5 0] )                          
        xlabel('Particle Size (mm)', 'Fontsize' , 9); 
        ylabel('Percentage Finer by Weight ' , 'Fontsize' , 9);
        
        set(gca,  'Xgrid' , 'on' , 'Ygrid' , 'on' , 'Xcolor' , [0 0 0.37] , 'Ycolor' , [0 0 0.37] , 'Box' , 'off' , 'XDir' , 'normal' , ...
                   'FontWeight' , 'Bold' , 'FontSize' , 7 , 'FontAngle' , 'Oblique' , 'XMinorTick' , 'on' , 'YMinorTick' , 'on', ...
                   'Xlim' , [0.01 10]  ,'Ylim', [0 100],'XTickLabel', { '0.01' ; '0.1' ; '1' ;  '10' } ); 
        

if percentage>50 & Gravel>Sand & finecontent>12

LL=input('What is the liquid limit:');

PL=input('What is the plastic limit:');

PI=LL-PL;



end


end


if percentage>50 & Gravel>Sand & (0<=finecontent && finecontent<=5)  & Cu>4 & ( 1<Cc && Cc<3)
	sprintf('Soil classification based on USCS is: \n GW (well-graded gravel)')

elseif  percentage>50 & Gravel>Sand &  (0<=finecontent && finecontent<=5 ) & Cu<=4 & (Cc<1 | Cc>3)
	sprintf('Soil classification based on USCS is: \n GP (poorly graded gravel)')

elseif percentage>50 & Gravel>Sand & finecontent>12 & (PI<0.73*(LL-20) | PI<4)
	sprintf('Soil classification based on USCS is: \n GM (silty gravel)')

elseif percentage>50 & Gravel>Sand & finecontent>12 & (PI> 0.73*(LL-20) &PI>7)

    sprintf('Soil classification based on USCS is: \n GC (clayey gravel)')
    
elseif percentage>50 & Gravel>Sand & finecontent>=12 & LL<50 & (4<PI && PI<7)& PI> (0.73*(LL-20))
    
    sprintf('Soil  classification based on USCS is: \n GC-GM ( silty,clayey gravel)')
    
   
    
    


 end


if percentage>50 & Gravel>Sand & (5<finecontent & finecontent<12)
    
    LL=input('What is the liquid limit:');

    PL=input('What is the plastic limit:');
    
    PI=LL-PL;
    
    
    if Cu>4 & (1<Cc & Cc<3) & (PI<0.73*(LL-20) | PI<4)
             sprintf('Soil classification based on USCS is: \n GW-GM (well graded gravel with silt)')
        
    elseif  Cu>4 & (1<Cc & Cc<3) & (PI> 0.73*(LL-20)) &PI>4
            sprintf('Soil classification based on USCS is: \n GW-GC (well graded gravel with clay)')
            
    elseif  Cu<=4 & (Cc<1 | Cc>3) & (PI<0.73*(LL-20) | PI<4)
            sprintf('Soil classification based on USCS is: \n GP-GM(poorly graded gravel with silt)')
            
            
    elseif Cu<=4 & (Cc<1 | Cc>3) & PI> 0.73*(LL-20) &PI>7
            sprintf ('Soil classification based on USCS is: \n GP-GC(poorly graded gravel with clay)')
         
    end
end
            
    



if   percentage>50 & Sand>Gravel & finecontent>12

LL=input('What is the liquid limit:');

PL=input('What is the plastic limit:');

PI=LL-PL;

end





if percentage>50 & Sand>Gravel & (5<finecontent & finecontent<12)
    
    LL=input('What is the liquid limit:');

    PL=input('What is the plastic limit:');
    PI= LL-PL;
    
    if Cu>6 & (1<Cc & Cc<3) & (PI<0.73*(LL-20) | PI<4)
        sprintf('Soil classification based on USCS is: \n SW-SM(well graded sand with silt)')
        
    elseif  Cu>6 & (1<Cc & Cc<3) & (PI> 0.73*(LL-20)) &PI>4
            sprintf('Soil classification based on USCS is: \n SW-SC(well graded sand with clay)')
            
    elseif (Cu<=6 | (Cc<1 | Cc>3))& (PI<0.73*(LL-20) | PI<4)
        sprintf('Soil classification based on USCS is: \n SP-SM(poorly graded sand with silt) ')
        
    elseif (Cu<=6 | Cc<1 | Cc>3)& (PI> 0.73*(LL-20)) &PI>4
        
       sprintf('Soil classification based on USCS is: \n SP-SC(poorly graded sand with clay)')
       
    end 
end

if percentage>50 & Sand>Gravel & (0<finecontent && finecontent<5) & Cu>6 & (1<Cc && Cc<3)
  
		sprintf('Soil classification based on USCS is: \n SW (well graded sand)')
elseif percentage>50 & Sand>Gravel & (0<finecontent && finecontent<5)& (Cu<=6 | Cc<1 | Cc>3)
	 sprintf('Soil classification based on USCS is: \n SP (poorly graded sand)')

else if  percentage>50 & Sand>Gravel & finecontent>12 &( PI< 0.73*(LL-20) | PI<4)
	sprintf('Soil classification based on USCS is: \n SM (silty sand)')

elseif percentage>50 & Sand>Gravel & finecontent>12 &( PI> 0.73*(LL-20) & PI>7)

	sprintf('Soil classification based on USCS is: \n SC (clayey sand)')
    
    elseif percentage>50 & Sand>Gravel & finecontent>12 & (4<PI && PI<7)& PI> (0.73*(LL-20))
        sprintf('Soil classification based on USCS is: \n SC-SM (silty-clayey sand)')

    end
end






if (percentage<50)

LL=input('What is the liquid limit:');

PL=input('What is the plastic limit:');

PI=LL-PL;

end

if (percentage<50) & LL<50 & PI>7 & PI> (0.73*(LL-20))
    
	sprintf('Soil classification based on USCS is: \n CL (clay of low plasticity)')
    
elseif ( percentage<50 & LL<50 & (PI<4 & PI> (0.73*(LL-20)))) | (percentage<50 & LL<50 & PI<0.73*(LL-20))
	sprintf('Soil classification based on USCS is: \n ML (silt)')
    
elseif (percentage<50) & LL<50 & (4<PI && PI<7)& PI> (0.73*(LL-20))
    sprintf('Soil classification based on USCS is: \n CL-ML(silty clay) ')

elseif  (percentage<50) & LL>=50 & (PI>=0.73*(LL-20))
	sprintf('Soil classification based on USCS is: \n CH (clay of high plasticity)')

elseif (percentage<50)& LL>50 & PI< 0.73*(LL-20)
    
	sprintf('Soil classification based on USCS is: \n MH (silt of high plasticity)')

end





