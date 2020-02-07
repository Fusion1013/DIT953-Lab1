package interfaces;

public interface IContainer<T> {
    public void Load(T loadable);

    public T Unload(int pos);
}
