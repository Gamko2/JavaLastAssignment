/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplexerproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marc
 */
public class Demultiplexer {

    private int OutputNr;
    private List<Output> outputs = new ArrayList<Output>();
    private List<Channel> refers = new ArrayList<Channel>();

    private static Demultiplexer demultiplexer = new Demultiplexer();

    private Demultiplexer() {
        for (int i = 0; i < 31; i++) {
            outputs.add(i, new Output((char) 0, i));
        }

    }

    public static Demultiplexer getDemultiplexer() {
        return demultiplexer;
    }

    public Output getOutput(int id) {
        return outputs.get(id);
    }

    public void demux(PCM pcm) {
        for (Output output : outputs) {
            if (output.isValueAssigned()) {
                if (output.getValue() > 127) {
                    System.out.print(((int) output.getValue() - 65536) + " ");
                } else {
                    System.out.print((int) output.getValue() + " ");
                }
            }

        }
        /*
        for (Channel channel : refers) {
            if (channel.getObserver() != null && channel.getObserver() instanceof Output && channel.getInput() != null && channel.getInput().isValueAssigned()) {
                Output output = (Output) channel.getObserver();
                if (output.getValue() > 127) {
                    System.out.print(((int) output.getValue() - 65536) + " ");
                } else {
                    System.out.print((int) output.getValue() + " ");
                }

            }
        }
        System.out.println("");
         */
    }

    public void refer(int channelId, int outputId, PCM pcm) {
        Channel channel;
        if (channelId < 16) {

            channel = pcm.getChannels()[channelId];
        } else {
            channel = pcm.getChannels()[channelId + 1];
        }
        channel.referenceChannel(demultiplexer.getOutput(outputId - 1));
        channel.getInput().setChanged();
        channel.getInput().notifyObservers();
        refers.add(channel);
    }

}
