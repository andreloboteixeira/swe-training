public class VersionControl {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    int bad;
    public VersionControl(int bad){
        this.bad = bad;
    }

    public boolean isBadVersion(int version){
        return version >= this.bad ? true : false;
    }

}
