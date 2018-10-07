package permissions;

public enum Permissions {
    READ(1),WRITE(2),EXECUTE(4);

    private Integer value;

    Permissions(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
