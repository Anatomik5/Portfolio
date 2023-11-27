We have cache constitutes of 4 bytes 
8 - log(2)4 = 6 bits difference 
deltaK = k1 XOR k2

-2 for shiftg to right

K = 6 + 2 * 16 = 38
Keyspace reduced from 2^64 to 2^38 

Let's find not full delta k kandidate

plot_k_t_XX is png folder for results and script for it is in scripts/Attack_B4 

DeltaK 15/16 = 33
DeltaK 14/15 = 40
DeltaK 13/14 = 35
DeltaK 12/13 = 9
DeltaK 11/12 = 28
DeltaK 10/11 = 50
DeltaK 9/10 = 3
DeltaK 8/9 = 5
DeltaK 7/8 = 49
DeltaK 6/7 = 61
DeltaK 5/6 = 59
DeltaK 4/5 = 26
DeltaK 3/4 = 25
DeltaK 2/3 = 58
DeltaK 1/2 = 29

Now for plot_nrtraces_t_XX is png folder for results and script for it is in scripts/Attack_B4_step
1/2 - 780k
2/3 - 770k
3/4 - not enough for difference bytes between 3/4
4/5 - 590k
5/6 - 670k
6/7 - 730k
7/8 - 250k
8/9 - 490k
9/10 - 1000k
10/11 - 270k
11/12 - 640k
12/13 - 690k
13/14 - 760k
14/15 -  not enough for difference bytes between 14/15
15/16 - 440k
nrtraces_explanation.txt is placed in scripts/nrtraces_explanation.txt

According to my calculation I should guess only 2 bits for each from 16 -> Overall 2^38 
In all_in_one, I calculated 14 bits

But with all_in_one I should find only 24 𝐵𝑖𝑡𝑠.
I understood The algorithm of second step, but I am bad in Matlab, so I cannot understand the reason of error im Matlab

Array indices must be positive integers or logical values.

Error in All_in_one (line 19)
                MSB6k1k2 = bitxor(bitxor(58, Sbox(msb6_k14+f)), Sbox(msb6_k15+n));

So I implemented my algorithm in scripts/All_in_one
I hope that you will understand it, and send me feedback about it.
I hope you will forgive me for that. 

