
n=1000000;
Byte1= 7; % change number for byte 1
Byte2= 8; % change number for byte 2
s = 10000;
t=zeros(n/s,64);
for m=s:s:n
    for deltaK= 0:63
        X = bitxor(P(1:m, Byte1),P(1:m, Byte2));
        target = (bitshift(X,-2)== deltaK);
        Q0 = T(find(target==1));
        Q1 = T(find(target==0));
        n0 = size(Q0,1);
        n1 = size(Q1,1);
        d(deltaK+1) = mean(Q1)-mean(Q0);
        t(m/s, deltaK+1)=d(deltaK+1)/sqrt(var(Q0)/n0+var(Q1)/n1);
    end
end
figure 

plot(s:s:n, t)
line(xlim, [4.5 4.5], 'Color', 'b', 'LineStyle', ':', 'LineWidth', 2);
title('Byte',Byte1)
xlabel('nr of traces used') 
ylabel('t-value') 


