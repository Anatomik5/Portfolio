traces = fread(fopen('Traces.dat', 'r'), [150000, 256], 'int8')';
plaintexts = fread(fopen('plaintexts.dat', 'r'), [16, 256], 'uint8')';
keySpace = 1:256;


for i = 1:size(traces, 1)

    mixColumns = traces(i, 50000:65000);
    
    stat = mean(mixColumns);
    
    keySpace = keySpace(find(stat == max(stat), 1));

    dlmwrite('keysets.txt', keySpace, '-append');
end