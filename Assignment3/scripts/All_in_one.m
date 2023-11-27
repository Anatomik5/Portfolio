
Collision = zeros(256, 1); 
Uncollision = zeros(256, 1);  
for k5 = 0:255
    msb6_k10 = bitxor(bitxor(bitxor(bitxor(bitxor(bitshift(k5,-2), 61 ), 49), 5),3),50); % msb6 for k10 
    msb6_k14 = bitxor(bitxor(bitxor(bitxor(msb6_k10, 28),9),35),40); % msb6 for k14
    msb6_k15 = bitxor(msb6_k14, 33); % msb6 for k15
    Sp5k5 = Sbox(bitxor(P(1:1000000, 5), k5)+1); % 𝑆(𝑝5 ⊕ 𝑘5) 
    for i = 0:3
    Sp10k10 = Sbox(bitxor(P(1:1000000, 10), msb6_k10+i)+1);%𝑆(𝑝10 ⊕ 𝑘10)
        for n = 0:3
            Sp15k15 =Sbox( bitxor(P(1:1000000, 10), msb6_k15+n)+1);%𝑆 (p15 ⊕ 𝑘15 )
            MSB6d1d2 = bitshift(bitxor(bitxor(bitxor(bitxor(bitxor(2*Sp5k5,Sp5k5),3*Sp10k10),2*Sp10k10),Sp15k15),Sp15k15*3),-2);% MSB6(𝑑1 ⊕ 𝑑2)
            for f = 0:3
            MSB6k1k2 =  bitxor(bitxor(58, Sbox(msb6_k14+f)), Sbox(msb6_k15+n)); %𝑀𝑆𝐵6(𝑘′1 ⊕ 𝑘′2)
                    Collision(k5 + 1) = find(MSB6d1d2 == MSB6k1k2);% When matches
                    Uncollision(k5 + 1) =find(MSB6d1d2 ~= MSB6k1k2);% When not matches
            end
        end
    end
    n0 = size(Collision,1);
    n1 = size(Uncollision,1);
    d(deltaK+1) = mean(Uncollision)-mean(Collision);
    t(deltaK+1)=d(deltaK+1)/sqrt(var(Collision)/n0+var(Uncollision)/n1); %tried to do t-value
end

figure 

plot(0:255, t)
xlabel('all key guesses') 
ylabel('t-value') 
