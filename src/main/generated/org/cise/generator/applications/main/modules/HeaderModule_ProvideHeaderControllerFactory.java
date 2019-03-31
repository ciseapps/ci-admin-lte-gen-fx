package org.cise.generator.applications.main.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

import org.cise.generator.applications.main.controllers.HeaderController;
import org.cise.generator.applications.main.controllers.MainController;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HeaderModule_ProvideHeaderControllerFactory
    implements Factory<HeaderController> {
  private final HeaderModule module;

  private final Provider<MainController> mainControllerProvider;

  public HeaderModule_ProvideHeaderControllerFactory(
      HeaderModule module, Provider<MainController> mainControllerProvider) {
    assert module != null;
    this.module = module;
    assert mainControllerProvider != null;
    this.mainControllerProvider = mainControllerProvider;
  }

  @Override
  public HeaderController get() {
    return Preconditions.checkNotNull(
        module.provideHeaderController(mainControllerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HeaderController> create(
      HeaderModule module, Provider<MainController> mainControllerProvider) {
    return new HeaderModule_ProvideHeaderControllerFactory(module, mainControllerProvider);
  }
}
