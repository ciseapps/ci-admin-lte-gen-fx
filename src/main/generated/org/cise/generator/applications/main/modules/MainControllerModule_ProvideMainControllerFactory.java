package org.cise.generator.applications.main.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

import org.cise.generator.applications.main.controllers.MainController;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainControllerModule_ProvideMainControllerFactory
    implements Factory<MainController> {
  private final MainControllerModule module;

  public MainControllerModule_ProvideMainControllerFactory(MainControllerModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public MainController get() {
    return Preconditions.checkNotNull(
        module.provideMainController(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MainController> create(MainControllerModule module) {
    return new MainControllerModule_ProvideMainControllerFactory(module);
  }
}
