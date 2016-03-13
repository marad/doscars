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

    public Map(String[] mapTemplate) {
        if (mapTemplate.length == 0) {
            throw new RuntimeException("Map is invalid");
        }
        this.width = mapTemplate[0].length();
        this.height = mapTemplate.length;
        this.map = new byte[width][height];
        parseMap(mapTemplate);
    }

    private void parseMap(String[] mapTemplate) {
        for(int y=0; y < mapTemplate.length; y++) {
            for(int x=0; x < mapTemplate[y].length(); x++) {
                if (mapTemplate[y].charAt(x) == '#') {
                    set(x, y, (byte)1);
                }
            }
        }
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

