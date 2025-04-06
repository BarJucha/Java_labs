package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.ByteOrder;
import javax.sound.sampled.*;

public class SoundVisualizer extends JPanel {

    private short[] audioData;
    private short[] filteredData;

    public SoundVisualizer(String filePath) {
        loadAudioData(filePath);
        loadFilteredData();
    }

    private void loadAudioData(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            AudioFormat audioFormat = audioInputStream.getFormat();
            int numFrames = (int) audioInputStream.getFrameLength();
            audioData = new short[numFrames];

            byte[] bytes_help = new byte[numFrames * audioFormat.getFrameSize()];
            audioInputStream.read(bytes_help);
            for(int i=0; i<numFrames; i++){
                short short_b = java.nio.ByteBuffer.wrap(bytes_help, i * audioFormat.getFrameSize(), audioFormat.getFrameSize()).order(ByteOrder.LITTLE_ENDIAN).getShort();
                audioData[i] = short_b;
            }
            //java.nio.ByteBuffer.wrap(audioBytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(audioData);

        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int maxAmplitude = getMaxAmplitude();

        g.setColor(Color.BLACK);

        for (int i = 0; i < audioData.length - 1; i++) {
            int x1 = i * width / audioData.length;
            int x2 = (i + 1) * width / audioData.length;
            int y1 = height / 2 - (int) (audioData[i] * height / (2.0 * maxAmplitude));
            int y2 = height / 2 - (int) (audioData[i + 1] * height / (2.0 * maxAmplitude));

            g.drawLine(x1, y1, x2, y2);
        }

        g.setColor(Color.RED);
        int scale = (int)audioData.length/width;
        for (int i = 0; i < filteredData.length - 1; i+=scale) {
            int x1 = i * width / filteredData.length;
            int x2 = (i + 1) * width / filteredData.length;
            int y1 = height / 2 + (int) (filteredData[i] * height / (2.0 * maxAmplitude));
            int y2 = height / 2 + (int) (filteredData[i + 1] * height / (2.0 * maxAmplitude));

            g.drawLine(x1, y1, x2, y2);
        }
    }

    private int getMaxAmplitude() {
        int maxAmplitude = 0;
        for (short sample : audioData) {
            maxAmplitude = Math.max(maxAmplitude, Math.abs(sample));
        }
        return maxAmplitude;
    }

    public void loadFilteredData(){
        int l = 5;
        int c = l/2;
        filteredData = new short[audioData.length];
        for(int i=c; i<audioData.length-c; i++){
            short up = audioData[i];
            for(int j=1; j<c; j++){
                up += audioData[i+j];
                up += audioData[i-j];
            }
            filteredData[i] = (short) (up/c);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sound Visualizer");
        SoundVisualizer visualizer = new SoundVisualizer("E:/Java/Programy Java/lab9/RecordAudio16.wav");
        frame.getContentPane().add(visualizer);
        frame.setSize(1600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

