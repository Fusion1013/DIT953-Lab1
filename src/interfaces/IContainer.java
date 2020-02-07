package interfaces;

public interface IContainer<T> {
    /***
     * Loads a loadable
     * @param loadable Loadable to load
     */
    public void Load(T loadable);

    /***
     * Unloads at position pos
     * @param pos Position to remove at
     * @return Unloaded object
     */
    public T Unload(int pos);
}
