package com.client.definitions;

import com.client.Stream;
import com.client.StreamLoader;
import com.client.Varp;

public final class VarBit {

    public static void unpackConfig(StreamLoader archive) {
        final Stream buffer = new Stream(archive.getDataForName("varbit.dat"));
        final int len = buffer.readUnsignedWord();
 
        if (cache == null) {
            cache = new VarBit[len];
        }
 
        System.out.println(String.format("Loaded: %d varbits", len));
 
        for (int i = 0; i < len; i++) {
            if (cache[i] == null) {
                cache[i] = new VarBit();
            }
 
            cache[i].decode(buffer);
 
            if (cache[i].aBoolean651) {
                Varp.cache[cache[i].anInt648].aBoolean713 = true;
            }
        }
 
        if (buffer.currentOffset != buffer.buffer.length) {
            System.out.println("varbit mismatch! " + buffer.currentOffset + " " + buffer.buffer.length);
        }
    }
 
    private void decode(Stream buffer) {
        int opcode = buffer.readUnsignedByte();
 
        if (opcode == 0) {
            return;
        } else if (opcode == 1) {
        	anInt648 = buffer.readUnsignedWord();
        	anInt649 = buffer.readUnsignedByte();
        	anInt650 = buffer.readUnsignedByte();
        } else {
            System.out.println(opcode);
        }
    }
 
    private VarBit() {
        aBoolean651 = false;
    }
 
    public static VarBit cache[];
    public int anInt648;
    public int anInt649;
    public int anInt650;
    private boolean aBoolean651;
}
