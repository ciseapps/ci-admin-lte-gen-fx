package org.cise.generator.applications.main.controllers;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.cise.generator.modules.green.GreenController;
import org.cise.generator.modules.red.RedController;
import org.cise.generator.modules.yellow.controllers.YellowController;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NavigationController_MembersInjector
    implements MembersInjector<NavigationController> {
  private final Provider<YellowController> yellowControllerProvider;

  private final Provider<RedController> redControllerProvider;

  private final Provider<GreenController> greenControllerProvider;

  public NavigationController_MembersInjector(
      Provider<YellowController> yellowControllerProvider,
      Provider<RedController> redControllerProvider,
      Provider<GreenController> greenControllerProvider) {
    assert yellowControllerProvider != null;
    this.yellowControllerProvider = yellowControllerProvider;
    assert redControllerProvider != null;
    this.redControllerProvider = redControllerProvider;
    assert greenControllerProvider != null;
    this.greenControllerProvider = greenControllerProvider;
  }

  public static MembersInjector<NavigationController> create(
      Provider<YellowController> yellowControllerProvider,
      Provider<RedController> redControllerProvider,
      Provider<GreenController> greenControllerProvider) {
    return new NavigationController_MembersInjector(
        yellowControllerProvider, redControllerProvider, greenControllerProvider);
  }

  @Override
  public void injectMembers(NavigationController instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.yellowController = yellowControllerProvider.get();
    instance.redController = redControllerProvider.get();
    instance.greenController = greenControllerProvider.get();
  }

  public static void injectYellowController(
      NavigationController instance, Provider<YellowController> yellowControllerProvider) {
    instance.yellowController = yellowControllerProvider.get();
  }

  public static void injectRedController(
      NavigationController instance, Provider<RedController> redControllerProvider) {
    instance.redController = redControllerProvider.get();
  }

  public static void injectGreenController(
      NavigationController instance, Provider<GreenController> greenControllerProvider) {
    instance.greenController = greenControllerProvider.get();
  }
}
