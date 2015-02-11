package org.multibit.hd.ui.fest.use_cases.security;

import org.fest.swing.fixture.FrameFixture;
import org.multibit.hd.core.dto.CoreMessageKey;
import org.multibit.hd.ui.fest.use_cases.AbstractFestUseCase;
import org.multibit.hd.ui.languages.MessageKey;

import java.util.Map;

/**
 * <p>Use case to provide the following to FEST testing:</p>
 * <ul>
 * <li>Verify the "security unsupported firmware" popover can be closed</li>
 * </ul>
 *
 * @since 0.0.1
 */
public class CloseUnsupportedFirmwareSecurityPopoverUseCase extends AbstractFestUseCase {

  public CloseUnsupportedFirmwareSecurityPopoverUseCase(FrameFixture window) {
    super(window);
  }

  @Override
  public void execute(Map<String, Object> parameters) {

    // Expect "unsupported firmware" popover to be showing
    window
      .panel(CoreMessageKey.UNSUPPORTED_FIRMWARE_ATTACHED.getKey())
      .requireVisible();

    // Dismiss
    window
      .button("security_alert." + MessageKey.CLOSE.getKey())
      .requireVisible()
      .requireEnabled()
      .click();

    // Allow time for the screen to close
    pauseForComponentReset();
  }

}
