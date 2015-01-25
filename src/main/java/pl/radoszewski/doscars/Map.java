package pl.radoszewski.doscars;

public class Map {
    private byte[][] map;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new byte[width][height];
    }

    public short get(int x, int y) {
        return map[x][y];
    }

    public void set(int x, int y, byte value) {
        map[x][y] = value;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

