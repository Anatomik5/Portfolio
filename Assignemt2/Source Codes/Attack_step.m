
parfor y=0:15
n=500000;
TargetByte =1;
t=zeros(n/10000,256);
P=csvread("Timing_Noisy.csv",0,y,[0,y,999999,y]);
T=csvread("Timing_Noisy.csv",0,16,[0,16,999999,16]);
for m=10000:10000:n
    for k=0:255
        MSB=bitget(Sbox(bitxor(P(1:m,TargetByte),k)+1),8);
        i0=find(MSB==0);
        i1=find(MSB==1);
    
        m0=mean(T(i0));
        m1=mean(T(i1));
        
        v0=var(T(i0));
        v1=var(T(i1));
        t(m/10000,k+1)=(m1-m0)/sqrt(v0/size(i0,1)+v1/size(i1,1));
    end
end
figure 

plot(10000:10000:n, t)
title('Byte',y)
xlabel('nr of traces used') 
ylabel('t-value') 
end

