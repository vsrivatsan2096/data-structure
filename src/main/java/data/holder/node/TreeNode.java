package data.holder.node;

abstract public class TreeNode<T> implements Node<T> {
    private T data;

    public TreeNode(T data) {
        this.data = data;
    }
    @Override
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
