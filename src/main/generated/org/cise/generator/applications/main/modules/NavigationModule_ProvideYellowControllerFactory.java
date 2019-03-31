package org.cise.generator.applications.main.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

import org.cise.generator.applications.main.controllers.MainController;
import org.cise.generator.modules.yellow.controllers.YellowController;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NavigationModule_ProvideYellowControllerFactory
    implements Factory<YellowController> {
  private final NavigationModule module;

  private final Provider<MainController> controllerProvider;

  public NavigationModule_ProvideYellowControllerFactory(
      NavigationModule module, Provider<MainController> controllerProvider) {
    assert module != null;
    this.module = module;
    assert controllerProvider != null;
    this.controllerProvider = controllerProvider;
  }

  @Override
  public YellowController get() {
    return Preconditions.checkNotNull(
        module.provideYellowController(controllerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<YellowController> create(
      NavigationModule module, Provider<MainController> controllerProvider) {
    return new NavigationModule_ProvideYellowControllerFactory(module, controllerProvider);
  }
}
