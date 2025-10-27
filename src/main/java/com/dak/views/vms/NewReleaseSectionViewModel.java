package com.dak.views.vms;

import com.dak.views.NewReleaseItemView;

public record NewReleaseSectionViewModel(
    SectionHeaderViewModel sectionHeaderViewModel,
    NewReleaseItemView[] newReleaseCardViews
) {}
