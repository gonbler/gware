package minegame159.meteorclient.utils;

import net.minecraft.nbt.NbtIo;

import java.io.File;
import java.io.IOException;

public abstract class Savable<T> implements ISerializable<T> {
    private final File file;

    public Savable(File file) {
        this.file = file;
    }

    public void save(File file) {
        try {
            System.out.println("Meteor-Client: Saving to " + file);
            file.getParentFile().mkdirs();
            NbtIo.write(toTag(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void save() {
        save(file);
    }

    public void load(File file) {
        try {
            if (file.exists()) {
                System.out.println("Meteor-Client: Loading from " + file);
                fromTag(NbtIo.read(file));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void load() {
        load(file);
    }

    public File getFile() {
        return file;
    }
}
