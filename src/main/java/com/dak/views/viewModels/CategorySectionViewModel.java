package com.dak.views.viewModels;

import com.dak.views.CategoryItemView;

public record CategorySectionViewModel(
    SectionHeaderViewModel sectionHeaderViewModel,
    CategoryItemView[] categoryItemViews
) {}
