package org.cise.generator.applications.main.modules;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

import org.cise.generator.applications.main.controllers.MainController;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NavigationModule_MembersInjector implements MembersInjector<NavigationModule> {
  private final Provider<MainController> controllerProvider;

  public NavigationModule_MembersInjector(Provider<MainController> controllerProvider) {
    assert controllerProvider != null;
    this.controllerProvider = controllerProvider;
  }

  public static MembersInjector<NavigationModule> create(
      Provider<MainController> controllerProvider) {
    return new NavigationModule_MembersInjector(controllerProvider);
  }

  @Override
  public void injectMembers(NavigationModule instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.providesNavigationController(controllerProvider.get());
    instance.provideYellowController(controllerProvider.get());
    instance.provideRedController(controllerProvider.get());
    instance.provideGreenController(controllerProvider.get());
  }
}
