
analyze_traces(traces(:, 1:end), 'Analyze');
mean_for_Matrix(traces(:, 50000:55000), 'Matrix 50000:55000');
variance_trace = var(traces, 1);
figure;
plot(variance_trace);
title('Variance of Power Values Across Traces');
xlabel('Sample Index');
ylabel('Variance');
grid on;

% Function to visualize power traces
function mean_for_Matrix(traces, title1)
    mean_trace = mean(traces, 1);
    figure;
    plot(mean_trace);
    title(['Mean Power Trace - ' title1]);
    xlabel('Sample Index');
    ylabel('Mean Power Value');
    grid on;
end




% Function to perform mean analysis and visualize results
function analyze_traces(traces, title1)
    mean_trace = mean(traces, 1);
    figure;
    plot(mean_trace);
    title(['Mean Power Trace - ' title1]);
    xlabel('Sample Index');
    ylabel('Mean Power Value');
    grid on;
end