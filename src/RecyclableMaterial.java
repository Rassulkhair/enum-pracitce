public class RecyclableMaterial {
    private int code;
    private MaterialType materialType;
    private boolean isRecyclable;
    private String description;

    public RecyclableMaterial(int code, MaterialType materialType, boolean isRecyclable, String description) {
        this.code = code;
        this.materialType = materialType;
        this.isRecyclable = isRecyclable;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public boolean isRecyclable() {
        return isRecyclable;
    }

    public String getDescription() {
        return description;
    }
}
