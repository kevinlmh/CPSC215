%Power Spectrum Estimation
%Yisheng Cai
clear all;

sum=0; %Initializing the sum.

%Input parameters for plotting
disp('This program computes the periodogram.');
filename=input('==> Enter the name of the file: \n','s');
fid=fopen(filename);
read_file=fread(fid);
Npts=input('==> Number of samples in the file: \n');
fsamp=input('==> sampling frequency: \n');

for k=1:Npts-1;
    A=input('Input the amplitude: ');
    f=input('Input the frequency: ');
    T=1/fsamp;
    theta=input('Input the phase: ');
    n=(0:1:Npts-1);
    x=A*(sin((2*pi*f*k*T)+theta));
    figure;
    subplot(Npts,1,k), plot(n,x);
    title ('Data samples x(n)')
    xlabel ('Sampling time');
    ylabel ('Amplitude');
    sum=(sum+x);
    y=fft(sum);
    subplot(Npts,1,k), plot(n,y);
    title ('Periodogram');
    xlabel ('Frequency (Hz)');
    ylabel ('Power (db)');
end


