package com.dak.views.vms;

import com.dak.views.CategoryItemView;

public record CategorySectionViewModel(
    SectionHeaderViewModel sectionHeaderViewModel,
    CategoryItemView[] categoryItemViews
) {}
