package com.applilcation.answer;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.HomeViewHolder> {
    private List<String> questions;
    private Map<Integer, Boolean> selects = new HashMap<>();

    public void setWormKnowledgeBeans(List<String> wormKnowledgeBeans) {
        this.questions = wormKnowledgeBeans;
        for (int i = 1; i < questions.size()+1; i++) {
            selects.put(i, false);
        }
    }



    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = View.inflate(parent.getContext(), R.layout.item_question, null);
        return new HomeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, final int position) {
        holder.tvQuestion.setText(questions.get(position));
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                switch (checkedRadioButtonId) {
                    case R.id.rb_1:
                        selects.put(position+1, true);

                        break;
                    case R.id.rb_2:
                        selects.put(position+1, false);

                        break;
                }
            }
        });
    }

    public Map<Integer, Boolean> getSelects() {
        return selects;
    }

    @Override
    public int getItemCount() {
        return questions == null ? 0 : questions.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        private TextView tvQuestion;
        private RadioButton rb1, rb2;
        private RadioGroup radioGroup;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tv_question_1);
            radioGroup = itemView.findViewById(R.id.rg_1);
            rb1 = itemView.findViewById(R.id.rb_1);
            rb2 = itemView.findViewById(R.id.rb_2);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
