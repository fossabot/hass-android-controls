# Home Assistant + Android Device Controls API
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fofalvai%2Fhass-android-controls.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fofalvai%2Fhass-android-controls?ref=badge_shield)


Super-WIP app for controlling Home Assistant using the upcoming [Android 11 Quick Access Device Controls](https://developer.android.com/preview/features/device-control) feature.

![](demo.gif)

### What's working:

- Fetch devices using Home Assistant's REST API
- Display current state and get updates via the WebSocket API
- Supported device types:
    - Light
    - Switch
    - Vacuum (no interaction, just displays state)
    - Camera (no interaction, just displays state)
- Control devices via single tap and slider

### TO-DO:

- Support more device types (Alarm, Climate, etc.)
- Configuration UI (connection params are hardcoded for now)
- Custom UI and controls when long pressing a device

### How to use

First, you need a device/emulator running Android 11 beta. Then clone the repo, set your URL and access token in `Config.kt` and build the app.

## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fofalvai%2Fhass-android-controls.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fofalvai%2Fhass-android-controls?ref=badge_large)