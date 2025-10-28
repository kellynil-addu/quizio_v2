package com.dak.views.viewModels;

import com.dak.views.NewReleaseItemView;

public record NewReleaseSectionViewModel(
    SectionHeaderViewModel sectionHeaderViewModel,
    NewReleaseItemView[] newReleaseCardViews
) {}
