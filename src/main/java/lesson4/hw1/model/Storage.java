package lesson4.hw1.model;

public class Storage {
    private long id;
    private String  formatsSupported;
    private String storageCountry;
    private long storageMaxSize;

    public Storage(long id, String formatsSupported, String storageCountry, long storageMaxSize) {
        this.id = id;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageMaxSize = storageMaxSize;
    }

    public Storage(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageMaxSize() {
        return storageMaxSize;
    }
}
