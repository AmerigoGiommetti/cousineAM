DELETE FROM recipes;

INSERT INTO recipes (
    name, season, course, info,
    meat, fish, eggs, cheese, legumes, carbs, veggies
) VALUES
(
    'Pasta al Pesto', 'Summer', 'Lunch',
    'Boil pasta, add pesto and serve chilled.',
    false, false, false, true, false, true, true
),
(
    'Bean Soup', 'Winter', 'Dinner',
    'Cook mixed beans with onion, celery, and carrot for 40 minutes.',
    false, false, false, false, true, false, true
),
(
    'Lemon Chicken', 'Spring', 'Lunch',
    'Cook chicken with lemon juice, garlic and rosemary.',
    true, false, false, false, false, false, true
);
