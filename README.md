# cordova-plugin-xwalk-helper

Simple plugin that controls the crosswalk webivew.

## API

### getVersion()

Retrieves the crosswalk version.

Example:

```
window.XWalk.getVersion(function(v) {
    console.log('crosswalk version is: ' + v);
});

```

### getRemoteDebuggingEnabled()

Checks if remote debugging via Chrome is enabled by checkin the underlying crosswalk flags.
see https://crosswalk-project.org/apis/embeddingapidocs/reference/org/xwalk/core/XWalkPreferences.html#REMOTE_DEBUGGING

Example:

```
window.XWalk.getRemoteDebuggingEnabled(function(f) {
    console.log('remote debugging is ' + (f ? 'enabled' : 'disabled'));
});

```

### setRemoteDebuggingEnabled()

Enables or disables remote debugging via Chrome by setting the underlying crosswalk flags.
see https://crosswalk-project.org/apis/embeddingapidocs/reference/org/xwalk/core/XWalkPreferences.html#REMOTE_DEBUGGING.

This can be useful for released applications that want to enable remote debugging. Crosswalk disables this by default for released applications.

Example:

```
window.XWalk.setRemoteDebuggingEnabled(true);

```


