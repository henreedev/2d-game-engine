package engine.resource;

public abstract class Resource {

  public Resource (String relativeFilepath) {
    loadResource(relativeFilepath);
  }

  protected abstract void loadResource(String relativeFilepath);
}
