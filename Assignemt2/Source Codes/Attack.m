parfor y = 0:15
n=1000000;
TargetByte =1;
t=zeros(1,256);
y=0;
P=csvread("Timing_Noisy.csv",0,y,[0,y,999999,y]);
T=csvread("Timing_Noisy.csv",0,16,[0,16,999999,16])
for k=0:255
   
    MSB=bitget(Sbox(bitxor(P(1:n,TargetByte),k)+1),8);
    i0=find(MSB==0);
    i1=find(MSB==1);

    m0=mean(T(i0));
    m1=mean(T(i1));
    
    v0=var(T(i0));
    v1=var(T(i1));
    t(k+1)=(m1-m0)/sqrt(v0/size(i0,1)+v1/size(i1,1));
end

figure 

plot(0:255, t)
title('Byte',y)
xlabel('all 256 key guesses') 
ylabel('t-value') 
end
