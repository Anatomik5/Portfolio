import numpy as np
import matplotlib.pyplot as plt

def read_trace_file(file_name): #method for reading the files
    with open(file_name, "rb") as file: #I am opening and reading file binary 
      num_traces = np.fromfile(file, dtype=np.uint32, count=1)[0] #Reading first data in uint32, it is my nr_of_points(uint32)
      traces = [] 
      for i in range(5): # I will have 5 traces arrays
        traces_data = np.fromfile(file, dtype=np.int8, count=num_traces)# Reading num_traces traces data 
        traces.append(traces_data) #adding data to the end of my array
      return num_traces, traces

def plot_trace(trace_data, file_name):#method for plotting all traces from 1 files in one png
    num_traces, traces = trace_data
    x_range = (0, num_traces)# x axe
    y_range = (-80,80)# y axe
    plt.figure(figsize=(40, 6))#set the lengthes of my plot
    plt.ylim(y_range)  #set y axe
    plt.xlim(x_range)  #Set x axe
    for i in range(5):# plotting 5 traces
      plt.subplot(1, 5, i + 1)
      plt.plot(range(num_traces), traces[i])
      plt.title(f'Trace {i+1} ')#just name
      plt.xlabel('Time')#just x name
      plt.ylabel('Power')#just y name
      plt.grid()#just grid lines
    plt.suptitle(f'Traces - {file_name}')
    plt.savefig(f'{file_name}.png')#saving png
    plt.close()#finish to work with plot

if __name__ == "__main__":#protect users from accidentally executing code from another module 
    file_names = [ "Traces_A.dat","Traces_B.dat"]#my files
    for file_name in file_names:
        trace_data = read_trace_file(file_name)#reading the files and saving result in trace_data
        plot_trace(trace_data, file_name)#plotting all traces from files in coordinate systems





