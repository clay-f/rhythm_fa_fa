package com.f.bigtalk.state;

public interface State {
    void Handle(Context context);
}
