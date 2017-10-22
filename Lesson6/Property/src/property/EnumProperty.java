package property;

public enum EnumProperty {
    CHOOSE_ROOM_STATUS("Boolean"),
    MAX_NUMBER_OF_LAST_ROOM_GUESTS("Integer"),
    ROOM_PATH_FILE("String"),
    SERIALIZABLE_PATH_FILE("String");

    private String type;

    private EnumProperty(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
