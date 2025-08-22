package com.ptk671.dhgloader.api.util;



import net.minecraft.util.Identifier;

import java.util.Objects;

public class DhgIdentifier {

    private final String namespace; // ここ:path
    private final String path; // namespace:ここ

    public DhgIdentifier(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }

    public DhgIdentifier(String id) {
        String namespace, path = "";

        String[] strings = id.split(":");
        if (strings.length == 1) {
            namespace = "minecraft";
            path = id;
        } else {
            namespace = strings[0];
            path = strings[1];
        }

        this.namespace = namespace;
        this.path = path;
    }

    public DhgIdentifier(Identifier id) {
        this(id.getNamespace(), id.getPath());
    }

    public static DhgIdentifier of(String namespace, String path) {
        return new DhgIdentifier(namespace, path);
    }

    public static DhgIdentifier of(String id) {
        return new DhgIdentifier(id);
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }

    public Identifier toMinecraft() {
        return Identifier.of(namespace, path);
    }

    @Override
    public String toString() {
        return namespace + ":" + path;
    }



    @Override
    public int hashCode() {
        return Objects.hash(namespace, path);
    }
}