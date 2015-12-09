package com.stefan.submit1.exercise5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stefan.submit1.R;

public class ViewPagerFragment extends Fragment {

    String[] beer = new String[]{"Mornin' Delight ", "Good Morning", "Heady Tropper", "Kentucky Brunch",
            "Norrlands Guld", "Pliny The Younger", "Pliny The Elder"};

    String[] rating = new String[]{"4.7 ", "4.7", "4.67", "4.66", "2.62", "4.59", "4.59"};

    String[] brewery = new String[]{"Toppling Goliath Brewing Company, Iowa, United States ", "Tree House Brewing Company, Massachusetts, United States", "The Alchemist, Vermont, United States", "Toppling Goliath Brewing Company, Iowa, United States", "Spendrups Bryggeri AB, Sweden", "Russian River Brewing Company, California, United States", "Russian River Brewing Company, California, United StatesStyle"};

    String[] style = new String[]{"American Double / Imperial Stout ", "American Double / Imperial Stout", "American Double / Imperial IPA", "American Double / Imperial Stout", "Dortmunder / Export Lager", "American Double / Imperial IPA", "American Double / Imperial IPA"};

    String[] abv = new String[]{"12.00%  ", "8.40%", "8.00%", "12.00%", "5.3%", "11.00%", "8.00%"};

    String[] review = new String[]{"This was my first time trying Md during the release. Prior to the release, I opened my bcbs 2014/13 and Kbs 15/12 and bcbs vr 2014 to remind myself of what goodness should be. And MD was up there with VR. The aroma/taste reminded me of slow drip coffee from single origin coffee beans blended perfect with maple syrup. The body was perfect as it had a fuller month feel than a Kbs but not as full as a VR.",
            "Phenomenal beer. So great. Looks like a classic imperial stout but with a rich brown, foamy head. The nose is of sweet amply syrup, with a more subtle coffee undertone. Kind of surprising given how strong of a coffee flavor their double shot has. The taste is more than expected. Definite maple, coffee, sweet and sticky. Nice think velvet body, but Sioux being syrupy. Without a doubt one of best 3 beers I've had the pleasure of trying.",
            "I was lucky enough to get some Heady Topper last week on a trip up to VT. I stood in line for two hours total at a couple of different places in Burlington and ended up with a little over a case, it was completely worth the wait. It is the most drinkable IPA I've ever tasted, very smooth, and as the can says it leaves you with \"wave after wave of hoppy goodness! Not to mention at 8% ABV one or two of these bad boys will leave feeling nice and hopped up. I only wish they would make more so more people could try this amazing beer!",
            "Pours like all TG stouts which nearly equates to motor oil. Of course the mouth feel will follow the pour which allows you to chew on the deliciousness that ensues. Scent is roasted coffee with chocolate and maple. Bit of booze in there as well. Flavor is something I've yet to find any other beer match between the coffee, maple, chocolate, molasses and balanced mouthfeel that lets you mull this beer over a bit.",
            "Swedish beer is fun to me because I can buy it at Systembolaget and anywhere else like 7-11, the later being of lower alcohol versions of the former. I only tried the lower alcohol version of this one, as there are other better Swedish beers to get in higher alcohol. Average in all ways, not really good but not bad either. Smells a bit of corn, all in all nothing special. Nevertheless I liked this beer and it served me well. I was still able to drink much with my friends, when I had a sore throat! It was very smooth in all ways. Take it for what it is and enjoy. Just a typical beer to drink and have a good time.",
            "Had this on opening day Feb 6, 2015 after waiting in line for 4.5 hrs in the pouring rain. It is a spectacular beer to have straight from the source. Although a very high abv it does not taste alcohol forward and is truly balanced with a good amount of hops on your tongue, a bit of grapefruit follow through and a floral scent. Had a great time drying off and warming up and 3 10oz pours along with some Elder and Blind Pig hit the spot. It is a special beer worth the effort.",
            "Poured clear amber color into a pint glass with a persistent fluffy white head. The aroma was the star of this beer: a monstrous blast of fresh hops, citric and spicy. The flavor was initially overwhelming sharp hop bitterness. This faded to a pleasant biscuity malt flavor. Medium high carbonation was almost prickly on the tongue, but helped round out the mouthfeel of a beer that could have otherwise been a touch heavy. Instead, it is an easy drinking beer that finishes clean and sweet, but short of sticky sweet, and with a hint of the citrus and spice of the hops. Overall, it is a fantastic IPA."};


    public ViewPagerFragment() {
        // add if needed
    }

    public static ViewPagerFragment newInstance(int position, int imageId) {
        ViewPagerFragment myfrag = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putInt("imageId", imageId);
        myfrag.setArguments(bundle);
        return myfrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_pager, container, false);

        // image
        int position = getArguments().getInt("position");
        int imageId = getArguments().getInt("imageId");
        ImageView iv = (ImageView) rootView.findViewById(R.id.ivViewPager);
        iv.setImageResource(imageId);

        // beer
        TextView beerTV = (TextView) rootView.findViewById(R.id.beer);
        beerTV.setText(beer[position]);

        // rating
        TextView ratingTV = (TextView) rootView.findViewById(R.id.rating);
        ratingTV.setText(rating[position]);

        // style
        TextView styleTV = (TextView) rootView.findViewById(R.id.style);
        styleTV.setText(style[position]);

        // abv
        TextView abvTV = (TextView) rootView.findViewById(R.id.abv);
        abvTV.setText(abv[position]);

        // brewery
        TextView breweryTV = (TextView) rootView.findViewById(R.id.brewery);
        breweryTV.setText(brewery[position]);


        // review
        TextView reviewTV = (TextView) rootView.findViewById(R.id.review);
        reviewTV.setText(review[position]);


        return rootView;
    }
}
