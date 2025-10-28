package com.dak.views.viewModels;

import com.dak.views.CategorySectionView;
import com.dak.views.NewReleaseSectionView;

public record HomePageViewModel(
    CategorySectionView categorySectionView,
    NewReleaseSectionView newReleaseSectionView
) {}
