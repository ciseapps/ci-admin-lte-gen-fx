package org.cise.generator.modules.login.constrollers;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.cise.generator.applications.main.controllers.MainController;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginController_MembersInjector implements MembersInjector<LoginController> {
  private final Provider<MainController> controllerProvider;

  public LoginController_MembersInjector(Provider<MainController> controllerProvider) {
    assert controllerProvider != null;
    this.controllerProvider = controllerProvider;
  }

  public static MembersInjector<LoginController> create(
      Provider<MainController> controllerProvider) {
    return new LoginController_MembersInjector(controllerProvider);
  }

  @Override
  public void injectMembers(LoginController instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.controller = controllerProvider.get();
  }

  public static void injectController(
      LoginController instance, Provider<MainController> controllerProvider) {
    instance.controller = controllerProvider.get();
  }
}
