package org.cise.generator.modules.login.constrollers;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.cise.generator.applications.main.controllers.MainController;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginController_Factory implements Factory<LoginController> {
  private final MembersInjector<LoginController> loginControllerMembersInjector;

  private final Provider<MainController> mainControllerProvider;

  public LoginController_Factory(
      MembersInjector<LoginController> loginControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    assert loginControllerMembersInjector != null;
    this.loginControllerMembersInjector = loginControllerMembersInjector;
    assert mainControllerProvider != null;
    this.mainControllerProvider = mainControllerProvider;
  }

  @Override
  public LoginController get() {
    return MembersInjectors.injectMembers(
        loginControllerMembersInjector, new LoginController(mainControllerProvider.get()));
  }

  public static Factory<LoginController> create(
      MembersInjector<LoginController> loginControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    return new LoginController_Factory(loginControllerMembersInjector, mainControllerProvider);
  }
}
